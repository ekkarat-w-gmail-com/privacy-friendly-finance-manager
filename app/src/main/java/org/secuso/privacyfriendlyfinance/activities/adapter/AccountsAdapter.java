package org.secuso.privacyfriendlyfinance.activities.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.secuso.privacyfriendlyfinance.R;
import org.secuso.privacyfriendlyfinance.domain.model.Account;

import java.util.List;

public class AccountsAdapter extends RecyclerView.Adapter<AccountViewHolder> {
    private Context context;
    private List<Account> accounts;

    public AccountsAdapter(Context context, List<Account> accounts) {
        this.context = context;
        this.accounts = accounts;
    }

    @NonNull
    @Override
    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_account, parent, false);

        return new AccountViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountViewHolder holder, int index) {
        Account account = accounts.get(index);
        holder.getTvAccountName().setText(account.getName());
        holder.getTvAccountBalance().setText(String.valueOf(account.getInitialBalance()));
        holder.getTvAccountBalance().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDebugToast("Clicked on balance");
            }
        });
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    private void showDebugToast(String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}