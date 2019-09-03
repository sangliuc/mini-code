package com.example;

import java.util.LinkedList;
import java.util.List;

public class App {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] intToStringArray = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int x, n = digits.length();
        String s;
        ans.add("");
        for (int i = 0; i < n; i++) {
            while (ans.peek().length() == i) {//当ans首结点长度为0时，把第一个数代表的字符依次加入链表，
                // 当首结点长度为1时，需要进行下次循环，依次弹出首结点，首结点再与后面的数代表的每个字符累加，加入到链表中
                // 此时首结点的长度为2，重复操作..........最后输出
                s = ans.remove();//先获取链表的首结点赋值到s，再删除首结点，避免下次再循环到，下次需要用到新的首结点
                char c1 = digits.charAt(i);
                x = Character.getNumericValue(c1);//char->int
                for (char c : intToStringArray[x].toCharArray()) {//用弹出的首结点去累加后面的字符
                    ans.add(s + c);
                   // System.out.println(ans.toString());
                }
            }
        }
        return ans;
    }
}
