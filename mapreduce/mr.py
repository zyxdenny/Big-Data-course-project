from mrjob.job import MRJob
        

class BFS(MRJob):
    def mapper(self, _, line):
        v = line.strip().split('|')
        id = v[0]
        adj = v[1].strip().split(' ')
        if adj[0] == '':
            adj = []
        dist = int(v[2])
        status = int(v[3])

        if status == 1:
            status = -1
            for m_id in adj:
                m_dist = dist + 1
                m_adj = []
                m_status = 1
                yield m_id, (m_adj, m_dist, m_status)
        
        yield id, (adj, dist, status)

    def reducer(self, key, values):
        id = key
        adj = []
        dist = 9999
        status = 0
        for node in values:
            adj_tmp = node[0]
            dist_tmp = node[1]
            status_tmp = node[2]

            if status_tmp == -1:
                adj = adj_tmp
                dist = dist_tmp
                status = -1
                break
            else:
                if len(adj_tmp) != 0:
                    adj = adj_tmp
                
                if dist_tmp < dist:
                    dist = dist_tmp
                
                if status_tmp == 1:
                    status = 1

        
        yield id, (adj, dist, status)


if __name__ == '__main__':
    BFS.run()
