/**
 * 选择排序
 * @param {*} arr 
 */
function selectionSort(arr) {
    for(let i = 0; i < arr.length; i++) {
        let minIndex = i;
        for(let j = i+1; j < arr.length; j++) {
            if(arr[j] < arr[i]) {
                minIndex = j;
            }
        }
        let t = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = t;
    }
    return arr;
}


console.log(selectionSort([1,2,3,3,45,5]));
console.log(selectionSort([9,8,7,6,5,4,3,2,1]));