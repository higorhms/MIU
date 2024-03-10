function binomialCoefficient(n, k) {
    let res = 1;
    for (let i = 0; i < k; i++) {
        res *= (n - i);
        res /= (i + 1);
    }
    return res;
}

function catalanNumber(n) {
      // Cn = (1/(n+1)) * (2n choose n)
    return binomialCoefficient(2 * n, n) / (n + 1);
}

let K = 3;

console.log(catalanNumber(K));