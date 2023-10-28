# 크루스칼 알고리즘 :
1. 주어진 간선에 대해서 연결비용이 낮은 순으로 오름차순 정렬 <br>
1-1. 정렬의 경우  Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));를 이용
2. 순차적으로 순회하면서 parent가 cycle이 없으면 간선의 양 끝 점을 Union
3. parent는 항상 작은 노드의 번호를 따라감
4. parent의 parent...parent를 확인 후 해당 node를 parent로 갖는다.
5. 모든 간선에 대해서 작업 수행 후 최소 신장 트리 구현 완료 -> 최소 비용 반환