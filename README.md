# UndirectedGraph

Graph Theory

Simple vs. Weighted Graphs
A simple graph is a notation that is used to represent the connection between pairs of objects. It consists of:

A set of vertices, which are also known as nodes. We denote a set of vertices with a V.
A set of edges, which are the links that connect the vertices. We denote the edges set with an E.
A weighted graph refers to a simple graph that has weighted edges. These weighted edges can be used to compute shortest path. It consists of:

A set of vertices V.
A set of edges E.
A number w (weight) that is assigned to each edge. Weights might represent things such as costs, lengths or capacities.
In a simple graph, the assumption is that the sum of all the weights is equal to 1.

Graph Types
In addition to simple and weighted descriptions, there two types of graphs:

Directed Graph: In a directed graph, edges have direction (edges with arrows connect one vertex to another).
Undirected Graph: In an undirected graph, edges have no direction (arrowless connections). It is basically the same as a directed graph but has bi-directional connections between nodes.


Minimum Spanning Tree:

A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. That is, it is a spanning tree whose sum of edge weights is as small as possible. More generally, any edge-weighted undirected graph (not necessarily connected) has a minimum spanning forest, which is a union of the minimum spanning trees for its connected components.



DESIGN & IMPLEMENTATION:

Java springboot application is used to implement the graph along with following operations:
1. Initialize graph
2. Get current graph
3. Add a new node
4. Delete a node
5. Connect nodes
6. Update weight
7. Return Minimum Spanning Tree



API DOCUMENTATION:

https://app.swaggerhub.com/apis/nagarwall6/Graph/1.0.0

https://app.swaggerhub.com/apis-docs/nagarwall6/Graph/1.0.0#/graph-controller



POSTMAN TEST:

curl -X POST \
  http://localhost:8080/initGraph/ \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 500' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 4770156c-1c1d-4af8-a868-5998eecdcd97,8c76eaf1-4aa3-4aa1-8244-576c1522f825' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
    "v": 4,
    "e": 5,
    "edges": [
        {
            "src": 0,
            "dest": 1,
            "weight": 10
        },
        {
            "src": 0,
            "dest": 2,
            "weight": 6
        },
        {
            "src": 0,
            "dest": 3,
            "weight": 5
        },
        {
            "src": 1,
            "dest": 3,
            "weight": 15
        },
        {
            "src": 2,
            "dest": 3,
            "weight": 4
        } 
    ]
}'



curl -X POST \
  http://localhost:8080/connectNodes/ \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 54' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 9765b07c-31f1-404e-aa39-e327e62b699e,d3d98a2a-97e4-4ddd-aceb-ccd59f466049' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
  "Node1"  : "1",
  "Node2"  : "2",
  "Weight" : "98"
}'


curl -X POST \
  http://localhost:8080/removeNode/ \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 18' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 36822256-49f7-4cc8-8a12-bf0e2482391a,aef09145-395a-42fd-9f6f-b229c47ef298' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
  "Node"  : "4"
}'

curl -X POST \
  http://localhost:8080/newNode/ \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 226' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 1795ac62-04e8-40bc-b859-83b3df70ede7,ae6740e9-ae12-420b-bb97-91db01db3511' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
  "v"  : "4",
  "e": 2,
    "edges": [
        {
            "src": 4,
            "dest": 1,
            "weight": 10
        },
        {
            "src": 4,
            "dest": 2,
            "weight": 6
        }
    ]
}'


curl -X POST \
  http://localhost:8080/updateWeight/ \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 54' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 74f7bd40-deea-424b-adbe-27fec4fb8d1a,fa1dedf8-520b-4ebe-a79f-edd00521ad29' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
  "Node1"  : "0",
  "Node2"  : "3",
  "Weight" : "11"
}'


curl -X GET \
  http://localhost:8080/getGraph \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 35' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: a6632841-2aad-436c-b512-118f21223ffd,4a6676f3-c85e-4433-b45b-e924fff018b5' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
  "Vertex" : "5",
  "Edge" : "10"
}'

curl -X GET \
  http://localhost:8080/getMST \
  -H 'Accept: */*' \
  -H 'Accept-Encoding: gzip, deflate' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Length: 35' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 22ced335-9d5d-4941-933e-bf06efe30b39,d59fab4b-980f-4b40-b81e-7ffed7c59c0d' \
  -H 'User-Agent: PostmanRuntime/7.20.1' \
  -H 'cache-control: no-cache' \
  -d '{
  "Vertex" : "5",
  "Edge" : "10"
}'
