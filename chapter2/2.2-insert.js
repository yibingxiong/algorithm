function insertSort(arr) {
    for(let i = 1; i < arr.length; i++) {
        let j = i;
        let t = arr[i];
        while(t <= arr[j] && j > 0) {
            arr[j] = arr[j-1];
            j--;
        }
        if(arr[0] < t) {
            j++;
        }
        arr[j] = t;
    }
    return arr;
}

console.log(insertSort([1,2,3,4,5,6]));
console.log(insertSort([9,8,7,6,5,4,3,2,1]));