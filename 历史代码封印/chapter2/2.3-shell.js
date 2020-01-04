function shellSort(arr) {
    let N = arr.length;
    let h = 1;
    while(h < N / 3) {
        h = 3*h+1;
    }

    while(h >= 1) {
        for(let i = h; i < N; i++) {
            for(let j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                let t = arr[j];
                arr[j] = arr[j - h];
                arr[j - h] = t;
            }
        }
        h = Math.floor( h / 3);
    }

    return arr;
}

console.log(shellSort([1,2,3,3,45,5]));
console.log(shellSort([9,8,7,6,5,4,3,2,1]));