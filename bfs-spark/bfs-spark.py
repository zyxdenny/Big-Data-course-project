from multiprocessing.pool import MapResult
from pyspark.context import SparkContext
from sklearn import neighbors
sc = SparkContext()

# label = 0 (not searched) | 1 (in the active queue) | 2 (searched, dead)

# taking input
def txtToVertex(record, sourceName):
    recordList = record.split('|')
    vtxName = recordList[0]
    neighbors = recordList[1].strip().split(' ')
    dist = int(recordList[2])
    visitLabel = int(recordList[3])
    if vtxName == sourceName:
        dist = 0
        visitLabel = 1
    return (vtxName, (neighbors, dist, visitLabel))

def takeTxtInput(filePath, sourceName):
    input = sc.textFile(filePath)
    return input.map(lambda record: txtToVertex(record, sourceName))

# print(takeTxtInput('data/adj_mat').take(5))

def mapper(v):
    name = v[0]
    data = v[1]
    neighbors = data[0]
    dist = data[1]
    label = data[2]
    mapResult = []
    vUpdated = v
    if label == 1:
        for neighbor in neighbors:
            neighborRecord = (neighbor, ([], dist + 1, 1))
            mapResult.append(neighborRecord)
        vUpdated = (name, (neighbors, dist, 2)) # searched
    mapResult.append(vUpdated)
    return mapResult

def reducer(data0, data1):
    # reduce the duplicate vertices, remaining the nearest (also greatest label attached)
    neighbors0 = data0[0]
    neighbors1 = data1[0]
    dist0 = data0[1]
    dist1 = data1[1]
    label0 = data0[2]
    label1 = data1[2]
    
    label = label0 if label0 > label1 else label1
    dist = dist0 if dist0 < dist1 else dist1
    neighbors = []
    if len(neighbors0) > 0:
        neighbors.extend(neighbors0)
    if len(neighbors1) > 0:
        neighbors.extend(neighbors1)
    
    reduceResult = (neighbors, dist, label)
    return reduceResult

if __name__ == '__main__':
    import sys
    if len(sys.argv) == 0:
        inputPath = 'data/adj_mat'
        outputPath = 'output'
        sourceName = 'ARCXPYP1187FB37123'
    else:
        inputPath = sys.argv[1]
        outputPath = sys.argv[2]
        sourceName = sys.argv[3]
    rdd = takeTxtInput(inputPath, sourceName)
    max_iter = 20
    for iter in range(max_iter):
        mapped = rdd.flatMap(mapper)
        # print(mapped.)
        rdd = mapped.reduceByKey(reducer)
    rdd.saveAsTextFile(outputPath)