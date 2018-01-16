package com.wz.pack.ui.login.presenter;

import com.wz.baselib.mvpbase.baseImpl.BasePresenterImpl;
import com.wz.pack.api.Api;
import com.wz.pack.api.retroft.ExceptionHelper;
import com.wz.pack.ui.login.contract.UserContract;
import com.wz.pack.ui.login.model.UserModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by wang_zhen1 on 2018/1/16 0016.
 */

public class UserPresenter extends BasePresenterImpl<UserContract.UserView>
        implements UserContract.UserPresenter {


    public UserPresenter(UserContract.UserView view) {
        super(view);
    }

    @Override
    public void getData(String name,String pwd) {
        Api.getInstance().getUser(name,pwd).subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                        view.showLoadingDialog("");
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserModel>() {
                    @Override
                    public void accept(UserModel userModel) throws Exception {
                        view.dismissLoadingDialog();
                        view.setData(userModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
                        ExceptionHelper.handleException(throwable);
                    }
                });
    }
}
