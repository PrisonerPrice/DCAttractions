package com.example.android.dcattractions;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.api.graphql.MutationType;
import com.amplifyframework.api.graphql.SubscriptionType;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.ResultListener;
import com.amplifyframework.core.StreamListener;
import com.amplifyframework.datastore.generated.model.Task;
import com.amplifyframework.storage.s3.AWSS3StoragePlugin;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataUtils dataUtils = new DataUtils(this);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        CategoryAdapter adapter = new CategoryAdapter(this,getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
            Log.i("AmplifyGetStarted", "Amplify is all setup and ready to go!");
        } catch (AmplifyException exception) {
            Log.e("AmplifyGetStarted", exception.getMessage());
        }

        /*
        Task task = Task.builder().title("My first task").description("Get started with Amplify").build();

        Amplify.API.mutate(task, MutationType.CREATE, new ResultListener<GraphQLResponse<Task>>() {
            @Override
            public void onResult(GraphQLResponse<Task> taskGraphQLResponse) {
                Log.i("AmplifyGetStarted", "Added task with id: " + taskGraphQLResponse.getData().getId());
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e("AmplifyGetStarted", throwable.toString());
            }
        });

        Amplify.API.query(Task.class, new ResultListener<GraphQLResponse<Iterable<Task>>>() {
            @Override
            public void onResult(GraphQLResponse<Iterable<Task>> iterableGraphQLResponse) {
                for(Task task : iterableGraphQLResponse.getData()) {
                    Log.i("AmplifyGetStarted", "Task : " + task.getTitle());
                }
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e("AmplifyGetStarted", throwable.toString());
            }
        });

        Amplify.API.subscribe(
                Task.class,
                SubscriptionType.ON_CREATE,
                new StreamListener<GraphQLResponse<Task>>() {
                    @Override
                    public void onNext(GraphQLResponse<Task> taskGraphQLResponse) {
                        Log.i("AmplifyGetStarted", "Subscription detected a create: " +
                                taskGraphQLResponse.getData().getTitle());
                    }

                    @Override
                    public void onComplete() {
                        // Whatever you want it to do on completing
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Log.e("AmplifyGetStarted", throwable.toString());
                    }
                }
        );

         */

        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {
            @Override
            public void onResult(UserStateDetails userStateDetails) {
                try {
                    Amplify.addPlugin(new AWSS3StoragePlugin());
                    Amplify.configure(getApplicationContext());
                    Log.i("StorageQuickstart", "All set and ready to go!");
                } catch (Exception e) {
                    Log.e("StorageQuickstart", e.getMessage());
                }
            }

            @Override
            public void onError(Exception e) {
                Log.e("StorageQuickstart", "Initialization error.", e);
            }
        });
    }
}
