class MaxPQ {
    constructor() {
        this.pq = [];
        this.N = 0;
    }

    isEmpty() {
        return this.N === 0;
    }

    size() {
        return this.N;
    }

    insert(v) {
        this.pq[++this.N] = v;
        this._swim(this.N);
    }

    delMax() {
        let max = this.pq[1];
        this._change(1, this.N--);
        this.pq[this.N++] = null;
        this._sink(1);
        return max;
    }
    _sink(k) {
        while(2 * k <= this.N) {
            let j = 2*k;
            if(j < this.N && this._less(j, j+1)) {
                j++;
            }
            if(!this._less(k, j)) {
                break;
            }
            this._change(k,j);
            k = j;
        }
    }
    _change(_i, _j) {
        let i = Math.floor(_i);
        let j = Math.floor(_j);
        let t = this.pq[i];
        this.pq[i] = this.pq[j];
        this. pq[j] = t;
    }
    _less(i, j) {
        let _i = Math.floor(i);
        let _j = Math.floor(j);
        return this.pq[_i] - this.pq[_j] < 0;
    }
    _swim(k) {
        while(k > 1 && this._less(k/2, k)) {
            this._change(k/2, k);
            k = k / 2;
        }
    }
}


let maxPQ = new MaxPQ();
maxPQ.insert(1);
maxPQ.insert(2);
maxPQ.insert(7);
maxPQ.insert(3);
maxPQ.insert(4);
maxPQ.insert(2);


console.log(maxPQ.delMax());