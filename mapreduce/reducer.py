from collections import defaultdict
import sys

def full_group_by(l, key=lambda x: x):
    d = defaultdict(list)
    for item in l:
        d[key(item)].append(item)
    return d.items()

iter_group = full_group_by(sys.stdin, key=lambda x: x.split('|')[0])

for key, group in iter_group:
    id = key
    adj = []
    dist = 9999
    status = 0
    for line in list(group):
        v = line.strip().split('|')
        adj_tmp = v[1].strip().split(' ')
        if adj_tmp[0] == '':
            adj_tmp = []
        dist_tmp = int(v[2])
        status_tmp = int(v[3])

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
                status == 1

    
    print(''.join((id, '|', ' '.join(adj), '|', str(dist), '|', str(status))))


