let aux = [];
function merge(arr, lo, mid, hi) {
    let i = lo;
    let j = mid + 1;
    for (let k = lo; k <= hi; k++) {
        aux[k] = arr[k];
    }

    for (let k = lo; k <= hi; k++) {
        if(i > mid) {
            arr[k] = aux[j++];
        }else if(j > hi) {
            arr[k] = aux[i++];
        }else if(aux[j] < aux[i]) {
            arr[k] = aux[j++];
        }else {
            arr[k] = aux[i++];
        }
    }
}
function sort(arr, lo, hi) {
    if(hi <= lo) {
        return;
    }
    let mid = Math.floor(lo + (hi - lo)/2);
    sort(arr, lo, mid);
    sort(arr, mid+1, hi);
    merge(arr, lo, mid, hi);
}
function mergeSort(arr) {
    sort(arr, 0, arr.length - 1);
    return arr;
}


function mergeSort2(arr) {
    let N = arr.length;
    for(let sz = 1; sz < N ; sz=sz+sz) {
        for (let lo = 0; lo < N -sz; lo += sz+sz) {
            merge(arr, lo, lo + sz -1, Math.min(lo+sz+sz-1, N-1));
        }
    }
    return arr;
}

console.log(mergeSort2([1,2,3,5,6,3,4]));
// console.log(arr)