/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentos.exams.questions;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import vj.helpers.Utils;

/**
 *
 * @author vjrojasb
 */
public class PrintTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode  tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        Utils.println("\t HIIIII");
        Utils.print(printTree(tree));
        Utils.println("ok");
    }
    
    public static String printTree(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        String str = "";
        int level = 1;
        String starLevel = "L";
        String jump = "\n";
        String pleft= "(";
        String pright= ")";
        String tab= "  ";
        TreeNode node;
        while (!queue.isEmpty()) {            
            int size = queue.size();
            str+= starLevel;
            for (int i = 0; i < size ; i++) {
                node = queue.poll();
                if(node==null) break;
                str+=pleft+node.value+pright;
                if(i < size-1)str+= ",";
                if(node.left!=null && node.right!=null){
                   queue.offer(node.left);
                   queue.offer(node.right);
                }
            }
            str+=jump;
            level++;
        }
        int cont = 1; 
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'L'){
                str = str.replaceFirst("L",repetead(level-1-cont,tab));
                cont++;
            }
            
        }
        return str;
    }
    
    static String repetead(int n,String str){
        List<String> list = Collections.nCopies(n, str);
        String rsp = "";
        for (String x : list) {
            rsp+= String.valueOf(x);
        }
        return rsp;
    }
    
    
    
    static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int v){
            value = v;
            left = right = null;
        }
    }
    
    
    
    
}
