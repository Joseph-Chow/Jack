package activity.www.picturedrawable.com.picturedrawable3d;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setListAdapter(new ExampleAdapter());
    }

    // =============================================================================
    // Private classes
    // =============================================================================

    /**
     * TODO: Scan the example package for activities and show them automatically.
     */
    private static class ExampleAdapter extends BaseAdapter {

        // =============================================================================
        // Private members
        // =============================================================================

        private final Class[] exampleActivities = new Class[]{SimpleExample.class, ViewGroupExample.class, ViewGroupReflectionExample.class, XmlInflateExample.class};

        // =============================================================================
        // Supertype overrides
        // =============================================================================

        @Override
        public int getCount() {
            return this.exampleActivities.length;
        }

        @Override
        public Class getItem(int i) {
            return this.exampleActivities[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View reusableView, ViewGroup viewGroup) {
            TextView view;

            if (reusableView != null) {
                view = (TextView) reusableView;
            } else {
                final Context context = viewGroup.getContext();
                final int listItemPadding = context.getResources().getDimensionPixelSize(R.dimen.mainActivityListItemPadding);
                view = new TextView(context);
                view.setGravity(Gravity.CENTER_VERTICAL);
                view.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, context.getResources().getDimensionPixelSize(R.dimen.mainActivityListItemHeight)));
                view.setPadding(listItemPadding, 0, listItemPadding, 0);
            }

            final Class activity = this.getItem(i);

            view.setText(activity.getSimpleName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), activity);
                    view.getContext().startActivity(i);
                }
            });

            return view;
        }
    }
}
