public class HashTable {
    // public for testing purposes
    public int buckets[];
    public int tombstone = -1;
    long A;
    long C;
    long M;
    long size2 = 0;
    int [] newbuck;
    public HashTable(long _a, long _c, long _m) {
        HashTable obj = this;

        obj.A = _a;
        obj.C = _c;
        obj.M = _m;
        size2 = (int)_m;
        buckets = new int[(int)_m];
    }

    public long hash(int key){
        long hash = 0;
        hash = ((A * key) + C) % M;
        return hash;
    }
    public long probe(long i,long k,long h){
        //math.pow
        //returns (long)(i -Math.pow(-1, k) * Math.pow(k, 2)) % M;
        return (i + k) % M;
    }

    public void insert(int key) {

  //Hash value calculated and used as index
      int i = (int) hash(key);
      //while slot !=0, insert key in next available slot
      while ( i < buckets.length && buckets[i] != 0) {
          i++;
        }
        if (i >= buckets.length){

           extend();
        }

       buckets[i] = key;

  }

    public void remove(int key) {
    //Searching for key in buckets
        for(int h =0; h < buckets.length; h++){
            if(buckets[h] == key){
                buckets[h] = 0;
            }
        }
    }

    public boolean find(int key) {
        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i] == key)
                return true;
            }
            return false;
        }

    public double loadFactor() {
        double count = 0;
        //These are the items in the table (size of the table)
        int i = 0;
        while(i < buckets.length){

            if(buckets[i] != 0){
                count++;

            }i++;
        }
        double loads = 0;
        double size_total = buckets.length;
        loads = count/size_total;
        return loads;
    }
    private void extend() {//copy()
        System.out.println("happening " + buckets.length);
        size2 = size2 * 2;
        newbuck = new int[(int)size2];
        for (int j = 0; j < buckets.length; j++ ){
         newbuck[j] = buckets[j];
        }
        buckets = newbuck;
        System.out.println("happening new " + buckets.length);

    }
}
