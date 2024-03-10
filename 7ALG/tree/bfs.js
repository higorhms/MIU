function bfs(graph, start){
  const queue = [start];
  const visited = new Set();

  while(queue.length > 0){
    const current = queue.shift();

    if(!visited.has(current)){
      visited.add(current);

      for(const adjacent of graph[current]){
        if(!visited.has(adjacent)){
          queue.push(adjacent);
        }
      }
    }
  }
}



function bfs(graph, start){
  const queue = [start];
  const visited = new Set();

  while(queue.length > 0){
    const current = queue.shift();

    if(visited.has(current) == false){
      visited.add(current);

      for(const adjacent of graph[current]){
      
        if(visited.has(adjacent) == false){
          queue.push(adjacent);
        }
      }
    }
  }
}



function bfs(graph, start){
  const queue = [start];
  const visited = new Set();

  while(queue.length > 0){
    const current = queue.shift();

    if(visited.has(current) == false){
      visited.add(current);

      for(const adjacent of graph[current]){

        if(visited.has(adjacent) == false){
          queue.push(adjacent);
        }
      }
    }
  }
}