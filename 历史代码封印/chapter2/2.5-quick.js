function partition(arr, lo, hi) {
    let i = lo;
    let j = hi + 1;
    let v = arr[lo];
    while(true) {
        while(arr[++i] < v) {
            if(i === hi) {
                break;
            }
        }
        while(v < arr[--j]) {
            if(j === lo) {
                break;
            }
        }
        if(i >= j) {
            break;
        }
        let k = arr[i];
        arr[i] = arr[j];
        arr[j] = k;

        
    }
    let k = arr[lo];
    arr[lo] = arr[j];
    arr[j] = k;
    return j;
}

function sort(arr, lo, hi) {
    if(hi <= lo) {
        return;
    }

    let j = partition(arr, lo, hi);

    sort(arr, lo, j - 1);
    sort(arr, j + 1, hi);
}

function quickSort(arr) {
    sort(arr, 0, arr.length - 1);
    return arr;
}

console.log(quickSort([1,4,2,3,5,0]))