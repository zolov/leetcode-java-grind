package ru.zolov.slidingwindow;

/**
 * @author skaiur
 */
public class BestTimeToBuyAndSellStockSolution {

    public static int maxProfit(int[] prices) {
        // Инициализируем два указателя. Left=покупаем, Right=продаем
        int left = 0;

        // Создаем переменную для максимальной прибыли
        int maxProfit = 0;
        // Пока правый указатель не достиг конца массива с ценами
        // каждую итерацию перемещаем правый указатель вправо
        for (int right = 1; right < prices.length; right++) {
            // Если цена под правым указателем меньше чем под левым
            if (prices[left] < prices[right]) {
                // то вычисляем новый максимум прибыли
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                // иначе перемещаем левый указатель на тот же индекс, где и правый
                left = right;
            }
        }

        // В конце цикла возвращаем максимальную прибыль
        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        // Инициализируем два указателя. Left=покупаем, Right=продаем
        int left = 0;
        int right = 1;

        // Создаем переменную для максимальной прибыли
        int maxProfit = 0;
        // Пока правый указатель не достиг конца массива с ценами
        while (right < prices.length) {
            // Если цена под правым указателем меньше чем под левым
            if (prices[left] < prices[right]) {
                // то вычисляем новый максимум прибыли
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                // иначе перемещаем левый указатель на тот же индекс, где и правый
                left = right;
            }
            // перемещаем правый указатель вправо
            right++;
        }
        // В конце цикла возвращаем максимальную прибыль
        return maxProfit;
    }

    public static void main(String[] args) {
        var prices = new int[]{
                10, 1, 5, 6, 7, 1,
                2, 3, 5, 6, 8, 10
        };
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit(prices));
    }
}