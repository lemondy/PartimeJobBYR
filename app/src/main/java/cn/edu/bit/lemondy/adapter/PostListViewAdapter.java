package cn.edu.bit.lemondy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.edu.bit.lemondy.activity.R;
import cn.edu.bit.lemondy.beans.Post;

/**
 * Created by lemon on 12-16.
 */
public class PostListViewAdapter extends BaseAdapter{
    private List<Post> posts = null;
    private Context context;
    private LayoutInflater layoutInflater;

    public PostListViewAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
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

    /**
     *
     * @param position
     * @param convertView 利用convertView缓存View对象，避免每次都要重新创建视图对象，耗时影响性能
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.listview_item,null);
            holder.imageView = (ImageView)convertView.findViewById(R.id.post_image);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.post_title);
            //holder.authorTextView = (TextView) convertView.findViewById(R.id.post_author);
            holder.timeTextView = (TextView) convertView.findViewById(R.id.post_time);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        String title = posts.get(position).getPostTitle();
        if(title.length()>15)
            holder.titleTextView.setText(title.substring(0,15));
        else
            holder.titleTextView.setText(title);
        //holder.authorTextView.setText(posts.get(position).getAuthorName());
        holder.timeTextView.setText(posts.get(position).getPostTime());
        return convertView;
    }

    /**
     * 利用ConvertView 和 ViewHolder 结合起来缓存视图对象，加快UI响应速度
     */
    static class ViewHolder{
        public ImageView imageView;
        public TextView titleTextView;
        public TextView authorTextView;
        public TextView timeTextView;
    }
}
