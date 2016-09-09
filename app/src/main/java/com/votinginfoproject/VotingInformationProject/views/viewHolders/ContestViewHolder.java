package com.votinginfoproject.VotingInformationProject.views.viewHolders;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.votinginfoproject.VotingInformationProject.R;
import com.votinginfoproject.VotingInformationProject.models.Contest;

/**
 * Created by marcvandehey on 4/21/16.
 */
public class ContestViewHolder extends ViewHolder implements DecoratedViewHolder {
    private final View mClickableView;
    private final TextView mTitle;
    private final TextView mDescription;
    private final TextView mSectionTitle;

    public ContestViewHolder(View itemView) {
        super(itemView);

        mClickableView = itemView.findViewById(R.id.clickable_view);
        mTitle = (TextView) itemView.findViewById(R.id.text_view_title);
        mDescription = (TextView) itemView.findViewById(R.id.text_view_description);
        mSectionTitle = (TextView) itemView.findViewById(R.id.text_view_section);
    }

    /**
     * Set the contest for the view holder to populate
     * <p/>
     * If section is set, the section title will be shown as well
     *
     * @param contest
     * @param section
     */
    public void setContest(Contest contest, String electionName, @Nullable String section, View.OnClickListener listener) {
        if (contest != null) {
            if (section != null && !section.isEmpty()) {
                mSectionTitle.setText(section);
                mSectionTitle.setVisibility(View.VISIBLE);
            } else {
                mSectionTitle.setVisibility(View.GONE);
            }

            // Populate the data into the template view using the data object
            if (contest.type.toLowerCase().equals("referendum")) {
                mDescription.setText(contest.referendumSubtitle);
                mTitle.setText(contest.referendumTitle);
            } else {
                mTitle.setText(contest.office);
                mDescription.setText(electionName);
            }

            mClickableView.setOnClickListener(listener);
        }
    }

    @Override
    public boolean shouldShowItemDecoration() {
        return mSectionTitle.getVisibility() == View.VISIBLE;
    }
}
