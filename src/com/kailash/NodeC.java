package com.kailash;

/**
 * Created by ongraph on 12/5/17.
 */
/*
This class represents the single Node in the link link on which we perform the operation like add the node, delete the node
etc.
 */
class NodeC {

    private Integer data;

    /**This node points the current node's pointer*/
    private NodeC headPoint;

    public NodeC(Integer data,NodeC headPoint)
    {
        this.data = data;
        this.headPoint = headPoint;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public NodeC getHeadPoint() {
        return headPoint;
    }

    public void setHeadPoint(NodeC headPoint) {
        this.headPoint = headPoint;
    }

    //Add toString method for printing the data inside it
    @Override
    public String toString()
    {
        return data+"";
    }
}