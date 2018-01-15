package com.wz.pack.ui.main.presenter;

import com.wz.baselib.mvpbase.baseImpl.BasePresenterImpl;
import com.wz.baselib.retroft.ExceptionHelper;
import com.wz.pack.api.Api;
import com.wz.pack.ui.main.bean.MainBean;
import com.wz.pack.ui.main.contact.MainContact;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * - @Author:  wang_zhen1
 * - @Time:  2018/1/15 0015 14:23
 * - @Description:  主界面Presenter
 */
public class MainPresenter extends BasePresenterImpl<MainContact.MainView>
        implements MainContact.presenter {

    public MainPresenter(MainContact.MainView view) {
        super(view);
    }

    @Override
    public void getData() {
        Api.getInstance().getGank().subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        addDisposable(disposable);
                        view.showLoadingDialog("");
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MainBean>() {
                    @Override
                    public void accept(@NonNull MainBean storiesBeen) throws Exception {
                        view.dismissLoadingDialog();
                        view.setData(storiesBeen);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.dismissLoadingDialog();
                        ExceptionHelper.handleException(throwable);
                    }
                });
    }
}
