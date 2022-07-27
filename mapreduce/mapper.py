import sys

# class vertex:
#     def __init__(self):
#         self.id = ''
#         self.adj = []
#         self.dist = 9999
#         self.stat = 0


for line in sys.stdin:
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
            print(m_id + '| |' + str(m_dist) + '|1')
    
    print(''.join((id, '|', ' '.join(adj), '|', str(dist), '|', str(status))))


