package space.yangshuai.ojsolutions.leetcode.weekly.contest248;

import java.util.HashSet;
import java.util.Set;

public class SolutionD {
    public int longestCommonSubpath(int n, int[][] paths) {
        int m = paths.length;
        int low = 0, high = 100005;
        while(high - low > 1){
            int h = high+low>>1;
            if(ok(paths, h)){
                low = h;
            }else{
                high = h;
            }
        }
        return low;
    }

    boolean ok(int[][] paths, int h)
    {
        Set<Long> set = null;
        for(int[] p : paths) {
            RollingHash61 ha = new RollingHash61(1000000007, p.length);
            for(int v :p)ha.add(v);
            if(set == null){
                set = new HashSet<>();
                for(int i = 0;i+h-1 < p.length;i++){
                    set.add(ha.h(i, i+h));
                }
            }else{
                Set<Long> nset = new HashSet<>();
                for(int i = 0;i+h-1 < p.length;i++){
                    long v = ha.h(i, i+h);
                    if(set.contains(v)){
                        nset.add(v);
                    }
                }
                set = nset;
            }
            if(set.size() == 0)return false;
        }
        return true;
    }

    public class RollingHash61
    {
        static final long mod = (1L<<61)-1;
        public long M;
        public long[] pows;
        public long[] hs;
        public int hp;

        public RollingHash61(long M, int n) {
            assert M > 0;
            assert n > 0;
            this.M = M;
            this.pows = makePows(M, n);
            this.hs = new long[n+1];
            this.hp = 0;
        }

        public long mul(long a, long b)
        {
            long al = a&(1L<<31)-1, ah = a>>>31;
            long bl = b&(1L<<31)-1, bh = b>>>31;
            long low = al * bl; // <2^62
            long mid = al * bh + bl * ah; // < 2^62
            long high = ah * bh + (mid>>>31); // < 2^60 + 2^31 < 2^61
            // high*2^62 = high*2 (mod 2^61-1)
            long ret = mod(mod(2*high + low) + ((mid&(1L<<31)-1)<<31));
            return ret;
        }

        public long mod(long a)
        {
            while(a >= mod)a -= mod;
            while(a < 0)a += mod;
            return a;
        }

        private long[] makePows(long M, int n)
        {
            long[] ret = new long[n+1];
            ret[0] = 1;
            for(int i = 1;i <= n;i++)ret[i] = mul(ret[i-1], M);
            return ret;
        }

        public void add(long x)
        {
            hs[hp+1] = mul(hs[hp], M) + x;
            if(hs[hp+1] >= mod)hs[hp+1] -= mod;
            hp++;
        }

        public long h(int l, int r)
        {
            assert l <= r;
            return mod(hs[r] - mul(hs[l], pows[r-l]));
        }
    }

}
