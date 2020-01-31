package com.wintech.codechef;

import com.wintech.io.BaseIn;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class May2012L_TWSTR {
    int N, Q, i, idx, highIdx, tidx;
    Recipe key;
    RecipeComparator recipeComparator = new RecipeComparator();
	public void solve(int testNumber, BaseIn in, PrintWriter out) {
        N = Integer.parseInt(in.next());
        Recipe[] recipes = new Recipe[N];

        for(i = 0; i < N; i++) {
            recipes[i] = new Recipe(in.next(), Integer.parseInt(in.next()));
        }
        Arrays.sort(recipes);
        //out.println(Arrays.toString(recipes));

        Q = Integer.parseInt(in.next());
        for(i = 0; i < Q; i++) {
            key = new Recipe(in.next(), 0);
            idx = Arrays.binarySearch(recipes, key, recipeComparator);
            //out.println(key + " " + idx);
            if(idx >= 0) {
                highIdx = idx;
                tidx = idx - 1;
                while(tidx >= 0 && recipeComparator.compare(recipes[tidx], key) == 0) {
                    if(recipes[highIdx].priority < recipes[tidx].priority) {
                        highIdx = tidx;
                    }
                    tidx--;
                }
                tidx = idx + 1;
                while(tidx < N && recipeComparator.compare(recipes[tidx], key) == 0) {
                    if(recipes[highIdx].priority < recipes[tidx].priority) {
                        highIdx = tidx;
                    }
                    tidx++;
                }

                out.println(recipes[highIdx].name);
            }
            else {
                out.println("NO");
            }
        }
	}

    class Recipe implements Comparable<Recipe> {
        String name;
        int priority;

        Recipe(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Recipe o) {
            int result = this.name.compareTo(o.name);
            if(result != 0)
                return result;

            if(this.priority < o.priority)
                return 1;
            else if(this.priority > o.priority)
                return -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "Recipe{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }

    class RecipeComparator implements Comparator<Recipe> {
        @Override
        public int compare(Recipe o1, Recipe o2) {
            //System.out.println("o1: " + o1);
            //System.out.println("o2: " + o2);
            if(o1.name.startsWith(o2.name))  {
                //System.out.println("Returns equal");
                return 0;
            }
            //System.out.println("Returns equal " + o1.name.compareTo(o2.name));
            return o1.name.compareTo(o2.name);
        }
    }
}
