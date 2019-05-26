// 将一个数组变成大根堆
function toBigHeap(arr) {
    let size = 0;
    let len = arr.length;
    for(let i =0; i< len;i++) {
        let index = i;
        while(arr[index] > arr[Math.round((index-1)/2)]) {
            swap(arr, index, Math.round((index-1)/2));
            index = Math.round((index-1)/2);
        }
    }
    return arr;
}

function swap(arr, i, j) {
    let tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp; 
}

// 下沉操作
function heapify(arr, index, heapSize) {
    let left = index * 2 +1;

    while(left < heapSize) {
        let largest = (left+1<heapSize && arr[left+1] > arr[left])? left+1: left;

        largest = arr[largest]>arr[index]?largest:index;

        if (largest === index) {
            break;
        }

        swap(arr, index, largest);
        console.log('arr', arr)
        index = largest;
        left = 2*index+1;
    }
}


function heapSort(arr) {
    let heap = toBigHeap(arr);
    console.log('生成的堆', heap);
    let heapSize = heap.length;
    swap(heap, 0, --heapSize);
    while(heapSize> 0) {
        heapify(heap, 0,heapSize);
        swap(heap, 0, --heapSize);
    }
    
    return heap;
}

let arr = [1,3,4,5,6,7,2];

console.log(heapSort(arr))
