package Design;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2025/02/28
 * @file M2353_设计食物评分系统.java
 * <p>
 * 思路
 * 模拟
 * 本题互斥条件，很像sql题
 * <p>
 * 注：
 * 除用对象外，也可以用Pair包装不同类型的数据
 * 处理优先队列的删除逻辑会超时
 */
public class M2353_设计食物评分系统 {
    class FoodRatings {
        private class FoodInfo implements Comparable<FoodInfo> {
            String name;
            Integer rating;

            public FoodInfo(String name, Integer rating) {
                this.name = name;
                this.rating = rating;
            }

            @Override
            public int compareTo(FoodInfo f) {
                return Objects.equals(this.rating, f.rating) ? this.name.compareTo(f.name) : f.rating - this.rating;
            }
        }

        private class CuisineInfo {
            String name;
            Integer rating;

            public CuisineInfo(String name, Integer rating) {
                this.name = name;
                this.rating = rating;
            }
        }

        private Map<String, PriorityQueue<FoodInfo>> sortedFoods;
        private Map<String, CuisineInfo> cuisineInfos;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            sortedFoods = new HashMap<>();
            cuisineInfos = new HashMap<>();
            for (int i = 0; i < foods.length; i++) {
                FoodInfo foodInfo = new FoodInfo(foods[i], ratings[i]);
                if (!sortedFoods.containsKey(cuisines[i])) {
                    sortedFoods.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(foodInfo);
                } else {
                    sortedFoods.get(cuisines[i]).add(foodInfo);
                }
                cuisineInfos.put(foods[i], new CuisineInfo(cuisines[i], ratings[i]));
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = cuisineInfos.get(food).name;
            sortedFoods.get(cuisine).add(new FoodInfo(food, newRating));
            cuisineInfos.put(food, new CuisineInfo(cuisine, newRating));
        }

        public String highestRated(String cuisine) {
            PriorityQueue<FoodInfo> q = sortedFoods.get(cuisine);
            while (!Objects.equals(q.peek().rating, cuisineInfos.get(q.peek().name).rating)) {
                q.poll();
            }

            return q.peek().name;
        }
    }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
}
