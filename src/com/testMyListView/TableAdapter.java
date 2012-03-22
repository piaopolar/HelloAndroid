package com.testMyListView;  
import java.util.List;  
import android.content.Context;  
import android.graphics.Color;  
import android.view.Gravity;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.BaseAdapter;  
import android.widget.ImageView;  
import android.widget.LinearLayout;  
import android.widget.TextView;  
public class TableAdapter extends BaseAdapter {  
    private Context context;  
    private List<TableRow> table;  
    public TableAdapter(Context context, List<TableRow> table) {  
        this.context = context;  
        this.table = table;  
    }  
    public int getCount() {  
        return table.size();  
    }  
    public long getItemId(int position) {  
        return position;  
    }  
    public TableRow getItem(int position) {  
        return table.get(position);  
    }  
    public View getView(int position, View convertView, ViewGroup parent) {  
        TableRow tableRow = table.get(position);  
        return new TableRowView(this.context, tableRow);  
    }  
    /**
     * TableRowView ʵ�ֱ���е���ʽ
     * @author hellogv
     */  
    class TableRowView extends LinearLayout {  
        public TableRowView(Context context, TableRow tableRow) {  
            super(context);  
              
            this.setOrientation(LinearLayout.HORIZONTAL);  
            for (int i = 0; i < tableRow.getSize(); i++) {//�����Ԫ��ӵ���   
                TableCell tableCell = tableRow.getCellValue(i);  
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(  
                        tableCell.width, tableCell.height);//���ո�Ԫָ���Ĵ�С���ÿռ�   
                layoutParams.setMargins(0, 0, 1, 1);//Ԥ����϶����߿�   
                if (tableCell.type == TableCell.STRING) {//�����Ԫ���ı�����   
                    TextView textCell = new TextView(context);  
                    textCell.setLines(1);  
                    textCell.setGravity(Gravity.CENTER);  
                    textCell.setBackgroundColor(Color.BLACK);//������ɫ   
                    textCell.setText(String.valueOf(tableCell.value));  
                    addView(textCell, layoutParams);  
                } else if (tableCell.type == TableCell.IMAGE) {//�����Ԫ��ͼ������   
                    ImageView imgCell = new ImageView(context);  
                    imgCell.setBackgroundColor(Color.BLACK);//������ɫ   
                    imgCell.setImageResource((Integer) tableCell.value);  
                    addView(imgCell, layoutParams);  
                }  
            }  
            this.setBackgroundColor(Color.WHITE);//������ɫ�����ÿ�϶��ʵ�ֱ߿�   
        }  
    }  
    /**
     * TableRow ʵ�ֱ�����
     * @author hellogv
     */  
    static public class TableRow {  
        private TableCell[] cell;  
        public TableRow(TableCell[] cell) {  
            this.cell = cell;  
        }  
        public int getSize() {  
            return cell.length;  
        }  
        public TableCell getCellValue(int index) {  
            if (index >= cell.length)  
                return null;  
            return cell[index];  
        }  
    }  
    /**
     * TableCell ʵ�ֱ��ĸ�Ԫ
     * @author hellogv
     */  
    static public class TableCell {  
        static public final int STRING = 0;  
        static public final int IMAGE = 1;  
        public Object value;  
        public int width;  
        public int height;  
        private int type;  
        public TableCell(Object value, int width, int height, int type) {  
            this.value = value;  
            this.width = width;  
            this.height = height;  
            this.type = type;  
        }  
    }  
}  
 
