
function MergeSort(lower, high){ 
  
  let mid = lower + high / 2;
  MergeSort(lower, mid)
  MergeSort(mid+1, high)
  merge()
}