package binaryblitz.com.binaryblitz.presentation.userlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import binaryblitz.com.binaryblitz.R;
import binaryblitz.com.binaryblitz.data.presentation.UserModel;
import binaryblitz.com.binaryblitz.presentation.userlist.interfaces.IViewUserList;
import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by ikakus on 10/27/17.
 */

public class AdapterUserList extends RecyclerView.Adapter<AdapterUserList.UserViewHolder> {
    private final Context mContext;
    private List<UserModel> mItems;
    private IViewUserList.OnUserItemClickListener mListener;

    public AdapterUserList(Context context) {
        mContext = context;
        mItems = new ArrayList<>();
    }

    public void setListener(IViewUserList.OnUserItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserModel user = mItems.get(position);
        holder.setUser(user);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setItems(List<UserModel> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.avatar)
        ImageView avatar;
        @BindView(R.id.firstName)
        TextView firstName;
        @BindView(R.id.lastNurname)
        TextView lastNurname;
        @BindView(R.id.email)
        TextView email;
        UserModel mUserModel;

        public void setUser(UserModel userModel){
            mUserModel = userModel;
            try {
                String url = userModel.getAvatarUrl();
                if (url != null) {
                    Picasso.with(mContext)
                            .load(url)
                            .error(R.mipmap.ic_launcher_round)
                            .into(avatar);
                } else {
                    Picasso.with(mContext)
                            .load(R.mipmap.ic_launcher_round)
                            .into(avatar);
                }
            } catch (Exception e) {
                Timber.e(e);
                Picasso.with(mContext)
                        .load(R.mipmap.ic_launcher_round)
                        .into(avatar);
            }
            firstName.setText(userModel.getFirstName());
            lastNurname.setText(userModel.getLastName());
            email.setText(userModel.getEmail());
        }

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mListener!= null) {
                mListener.onUserItemClicked(mUserModel);
            }
        }
    }
}
