package top.ityf.service;

/**
 * ClassName:AccountService
 * Package: top.ityf.service
 * Description: 账户的业务层接口
 *
 * @Date: 2020/2/13 18:09
 * @Author: YanFei
 */
public interface AccountService {
    /**
     * 模拟保存账户
     * */
    void saveAccount();

    /**
     * 模拟更新账户
     * */
    void updateAccount(int i);

    /**
     * 删除账户
     * */
    int deleteAccount();
}
