# mat = [[0, 2, 3, -1, -1],
#        [2, 0, -1, 4, -1],
#        [3, -1, 0, 9, 2],
#        [-1, 4, 9, 0, 1],
#        [-1, -1, 2, 1, 0]]


class Graph():
    def __init__(self, vert):
        self.numVert = vert
        self.graph = []

    def addEdge(self, fr, to, weight):
        self.graph.append([fr, to, weight])

    def printDists(self, x, arr):
        print("Distance from " + str(x))
        for i in range(self.numVert):
            print(str(i) + "\t" * 2 + str(arr[i]))

    def bfAlgo(self, source):
        cost = [float('inf')] * self.numVert
        cost[source] = 0

        for _ in range(self.numVert - 1):
            for fr, to, weight in self.graph:
                if cost[fr] != float('inf') and cost[fr] + weight < cost[to]:
                    cost[to] = cost[fr] + weight

        self.printDists(source, cost)


def startNon_mat():
    n = int(input("Enter number of vertices: "))
    g = Graph(n)
    x = 0
    while x == 0:
        x = int(input("Enter 1 to insert an edge \n Enter 2 to display Distance Vector\n"))
        if x == 1:
            fr = int(input("Enter source: "))
            to = int(input("Enter destination: "))
            w = int(input("Enter weight: "))
            g.addEdge(fr, to, w)
            x = 0
        else:
            for i in range(5):
                g.bfAlgo(i)


def start_mat():
    n = int(input("Enter number of vertices: "))
    g = Graph(n)
    print("Enter the matrix: \n")
    arr = []
    for i in range(n):
        temp = list(map(int, input().split(" ")))
        arr.append(temp)

    for i in range(n):
        for j in range(n):
            if arr[i][j] != -1 and arr[i][j] != 0:
                g.addEdge(i, j, arr[i][j])

    for i in range(5):
        g.bfAlgo(i)


start_mat()
