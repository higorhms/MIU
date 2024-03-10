/*
/
/ input = [ 'A', 'B','C', 1, 2, 3, '4', '5', 6, '@', '~', 'D' ]
/
/ Split the string, integer, and special characters into new arrays. 
/ Make sure 4 and 5 which is a string should be in integer array list
/ and convert it to integer.
/ 
*/

let input = [ 'A', 'B','C', 1, 2, 3, '4', '5', 6, '@', '~', 'D' ];
let lettersAux = "abcdefghijklmnopqrstuvwxyz";
let numbersAux = "0123456789";

function splitArray(arr){
  const letters = [];
  const numbers = [];
  const special = [];

  for(let i = 0; i < arr.length; i++){
    if(lettersAux.includes(String(arr[i]).toLowerCase())){
      letters.push(arr[i]);
    }else if(numbersAux.includes(arr[i])){
      numbers.push(+arr[i]);
    }else{
      special.push(arr[i]);
    }
  }

  console.log(letters)
  console.log(numbers)
  console.log(special)
}

splitArray(input);







/*
integer = [1,2,3,4,5,6]  
  Split it to 2 arrays with random elements and sum each array
    example: 
      Output_1: 
        array_1 = [ 1,4,6 ]
        array_2 = [ 2,3,5 ]
                  
      Output_2: Sum each array
        array_1 = 11
        array_2 = 10
*/

let inputB = [1,2,3,4,5,6];

function sumRandomArrays(arr){
  const arr1 = [];
  const arr2 = [];
  let counter = arr.length;

  while(counter != 0){
    let index = getRandomIndex(arr.length);
    arr1.push(arr[index]);
    arr = arr.filter((_, index2) => index != index2);
    counter--;

    index = getRandomIndex(arr.length);
    arr2.push(arr[index]);
    arr = arr.filter((_, index2) => index != index2);
    counter--;
  }

  console.log(`Array 1: ${arr1} Sum: `, arr1.reduce((a,b) => a+b));
  console.log(`Array 2: ${arr2} Sum: `, arr2.reduce((a,b) => a+b));
}

function getRandomIndex(length){
  return parseInt(Math.random() * length);
}

sumRandomArrays(inputB);

