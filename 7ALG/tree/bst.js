const fixedTree = insert(null, 10);
insert(fixedTree, 15);
insert(fixedTree, 8);
insert(fixedTree, 20);
insert(fixedTree, 13);
insert(fixedTree, 5);
insert(fixedTree, 9);

// ---------------------------

class Node{
  data = null;
  left = null;
  right = null;
}

function insert(current, key){
  if(!current){
    const n = new Node();
    n.data = key;
    return n;
  }else if(current.data === key){
    return current;
  }else if(key > current.data){
    current.right = insert(current.right, key);
  }else{
    current.left = insert(current.left, key);
  }

  return current;
}

let root = insert(null, Math.trunc(Math.random() * 100));

for(let i = 0; i < 10; i++){
  insert(root, Math.trunc(Math.random() * 100));
}


function preorder(node){
  if(node){
    console.log("=>", node.data);
    preorder(node.left);
    preorder(node.right);
  }
}

console.log(JSON.stringify(root));