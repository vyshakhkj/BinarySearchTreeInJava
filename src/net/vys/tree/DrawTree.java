package net.vys.tree;

import javax.swing.*;
import java.awt.*;

public class DrawTree extends JPanel {

    public BinarySearchTree tree;

    public DrawTree(BinarySearchTree tree){
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub

        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        //g.drawString(String.valueOf(tree.root.data), this.getWidth()/2, 30);


        //DrawNode(g, tree.root,100, 50,2);

        DrawTree(g, 0, getWidth(), 0, getHeight() / tree.getHeight(tree.root), tree.root);
    }

    public void DrawNode(Graphics g,Node n,int w,int h,int q){
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if(n!=null){

            g.drawString(String.valueOf(n.getData()), (this.getWidth()/q)+w, h);
            if(n.getLeftNode() !=null)
                DrawNode(g, n.getLeftNode(), -w, h*2, q);
            //DrawNode(g, n.left, -w, h*2, q);
            //g.drawString(String.valueOf(n.left.data), (this.getWidth()/q)-w, h+50);
            if(n.getRightNode() !=null)
                DrawNode(g, n.getRightNode(), w*2, h*2, q);
            //g.drawString(String.valueOf(n.right.data), (this.getWidth()/q)+w, h+50);
        }




    }


    public void DrawTree(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, Node node) {
        String data = String.valueOf(node.getData());
        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        int dataWidth = fm.stringWidth(data);
        g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);

        if (node.getLeftNode() != null)
            DrawTree(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.getLeftNode());

        if (node.getRightNode() != null)
            DrawTree(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.getRightNode());
    }
}
