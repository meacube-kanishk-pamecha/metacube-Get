public class Pos {
    
        int i ;
        int j;
        Pos(int i, int j ){
            this.i=i;
            this.j=j;
        }
        @Override
        public String toString() {
        return i+" "+j;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + i;
            result = prime * result + j;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pos other = (Pos) obj;
            if (i != other.i)
                return false;
            if (j != other.j)
                return false;
            return true;
        }
        

    
}
