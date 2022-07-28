from mrjob.job import MRJob
from mrjob.job import MRStep


class BFS(MRJob):
    def configure_args(self):
        super(BFS, self).configure_args()
        self.add_passthru_arg('-f', '--function',type=int, choices=[0,1],help='select function for the program. 0 for getting similar artists within a given distance. 1 for getting the distance between two artists')
        self.add_passthru_arg('-i', '--input_id', type=str,
                                help='set the input artist id')
        self.add_passthru_arg('-t', '--target_id', type=str,
                                help='set the target artist id')
        self.add_passthru_arg('-m', '--max_round', type=int, default = 10,
                                help='set the maximum round of searching')
        self.add_passthru_arg('-d', '--distance', type=int, default = 2,
                                help='set the expected distance')



    def mapper(self, _, line):
        v = line.strip().split('|')
        id = v[0]
        adj = v[1].strip().split(' ')
        if adj[0] == '':
            adj = []
        dist = int(v[2])
        status = int(v[3])
        path = []

        if id == self.options.input_id:
            path.append(id)
            status = -1
            dist = 0
            for m_id in adj:
                m_dist = dist + 1
                m_adj = []
                m_status = 1
                m_path = path + [m_id]
                yield m_id, (m_adj, m_dist, m_status, m_path)
        
        yield id, (adj, dist, status, path)


    def reducer(self, key, values):
        id = key
        adj = []
        dist = 9999
        status = 0
        path = []
        for node in values:
            adj_tmp = node[0]
            dist_tmp = node[1]
            status_tmp = node[2]
            path_tmp = node[3]

            if status_tmp == -1:
                adj = adj_tmp
                dist = dist_tmp
                status = -1
                path = path_tmp
                break
            else:
                if len(adj_tmp) != 0:
                    adj = adj_tmp
                
                if dist_tmp < dist:
                    dist = dist_tmp
                
                if status_tmp == 1:
                    status = 1

                if len(path_tmp) != 0:
                    path = path_tmp

        
        yield id, (adj, dist, status, path)


    def mapper_from_output(self, key, values):
        id = key
        adj = values[0]
        dist = values[1]
        status = values[2]
        path = values[3]

        if status == 1:
            status = -1
            for m_id in adj:
                m_dist = dist + 1
                m_adj = []
                m_status = 1
                m_path = path + [m_id]
                yield m_id, (m_adj, m_dist, m_status, m_path)
        
        yield id, (adj, dist, status, path)

    
    def mapper_final(self, key, values):
        id = key
        dist = values[1]
        yield dist, id


    def reducer_final0(self, key, values):
        dist = key
        id_list = []
        if dist == self.options.distance:
            for id in values:
                id_list.append(id)
            
            yield dist, id_list

    
    def reducer_final1(self, key, values):
        if key == self.options.target_id:
            id = key
            dist = 9999
            path = []
            for node in values:
                dist_tmp = node[1]
                status_tmp = node[2]
                path_tmp = node[3]

                if status_tmp == -1:
                    dist = dist_tmp
                    path = path_tmp
                    break
                else:
                    if dist_tmp < dist:
                        dist = dist_tmp

                    if len(path_tmp) != 0:
                        path = path_tmp
            
            yield id, (dist, path)
    

    def steps(self):
        process_list = [MRStep(mapper=self.mapper, reducer=self.reducer)]
        if self.options.function == 0:
            for i in range(self.options.distance - 1):
                process_list.append(MRStep(mapper=self.mapper_from_output, reducer=self.reducer))

            process_list.append(MRStep(mapper=self.mapper_final, reducer=self.reducer_final0))
        else:
            for i in range(self.options.max_round - 2):
                process_list.append(MRStep(mapper=self.mapper_from_output, reducer=self.reducer))
            
            process_list.append(MRStep(mapper=self.mapper_from_output, reducer=self.reducer_final1))

        return process_list


if __name__ == '__main__':
    BFS.run()
