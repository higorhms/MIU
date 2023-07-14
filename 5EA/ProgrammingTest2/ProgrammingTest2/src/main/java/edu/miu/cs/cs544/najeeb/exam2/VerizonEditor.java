package edu.miu.cs.cs544.najeeb.exam2;

import java.beans.PropertyEditorSupport;

public class VerizonEditor extends PropertyEditorSupport {
    private String delimiter;

    public VerizonEditor(String delimiter){
        this.delimiter = delimiter;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        String[] inputs = text.split(delimiter);
        Verizon verizon = new Verizon(Integer.parseInt(inputs[1]), inputs[2]);
        setValue(verizon);
    }

}
