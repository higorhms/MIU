Array.prototype.odd = function() {
    return this.filter((el) => {
        return el % 2 !== 0;
    });
}

Array.prototype.even = function(){
    return this.filter((el) => {
        return el % 2 === 0;
    });
}

console.log("Even result: " + [1,2,3,4,5,6,7,8].even()); // [2,4,6,8]
console.log("Odd result: " + [1,2,3,4,5,6,7,8].odd());// [1,3,5,7]
