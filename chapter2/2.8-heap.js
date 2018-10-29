function sink(l,s,m){
    var temp=l[s];
    for(var j=2*s+1;j<m;j=2*j+1){
        if(j<m&&l[j]<l[j+1])
            ++j;
        if(temp>=l[j])
          break;
        l[s]=l[j];
        s=j;
        }
       l[s]=temp;
}
function each(l,i,j){
    var temp=l[i];
    l[i]=l[j];
    l[j]=temp;
}
function HeapSort(l){
    for(var i=Math.floor(l.length/2);i>=0;i--) {
        sink(l,i,l.length);
    }
    for(var i= Math.floor(l.length);i>0;i--){
        each(l,0,i-1);
        sink(l,0,i-2);
    }
    return l;
}



console.log(HeapSort([1,3,2,5,0]))