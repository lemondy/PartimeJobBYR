package cn.edu.bit.lemondy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.bit.lemondy.activity.R;
import cn.edu.bit.lemondy.beans.Post;

/**
 * Created by lemon on 12-18.
 */
public class PostDetailAdapter extends BaseAdapter{
    private List<Post> posts = null;
    private Context context;
    private LayoutInflater layoutInflater;

    public PostDetailAdapter(Context context,List<Post> p){
        this.context = context;
        this.posts = p;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.web_detial_list_view,null);
            holder.imageView = (ImageView)convertView.findViewById(R.id.icon_image_view);
            holder.contentEditText = (EditText)convertView.findViewById(R.id.post_content_text);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        String title = posts.get(position).getPostTitle();

        //holder.authorTextView.setText(posts.get(position).getAuthorName());
        holder.imageView.setImageBitmap(posts.get(position).getPostBitmap());
        holder.contentEditText.setText(posts.get(position).getPostContent());
        return convertView;
    }

    static class ViewHolder{
        public ImageView imageView;
        public EditText contentEditText;
    }
}
