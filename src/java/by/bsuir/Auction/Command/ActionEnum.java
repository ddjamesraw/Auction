/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.Auction.Command;

/**
 *
 * @author DDJames
 */
public enum ActionEnum {

    MAIN(MainAction.class),
    ADMINVIEW(AdminMainViewAction.class),
    ADMINMAIN(AdminMainAction.class),
    ADDTHING(AddThingAction.class),
    UPDATETHING(UpdateThingAction.class),
    ADMINDEAL(AdminGoodsAction.class),
    LOGINADMIN(LoginAdminAction.class),
    DELETETHING(DeleteThingAction.class),
    ADDADMIN(AddNewAdminAction.class),
    ADMINTARIFF(AdminTariffAction.class),
    SHOWTHING(ShowThingAction.class),
    BIDACTION(BidAction.class),
    PROFILE(ProfileAction.class),
    LOGIN(LoginAction.class),
    REGISTER(RegistrationAction.class),
    SETBID(SetBidAction.class),
    SHOWPROFIT(ShowProfitAction.class),
    STATISTIC(StatisticAction.class),
    STATISTICBID(StatisticBidAction.class),
    STATISTICADMIN(StatisticAdminAction.class),
    STATISTICADMINBID(StatisticAdminBidAction.class),
    ABOUT(AboutAction.class),
    ADDTARIFF(AddNewTariffAction.class),
    BUYTARIFF(BuyNewTariffAction.class),
    UPDATETARIFF(UpdateTariffAction.class),
    DELETETARIFF(DeleteTariffAction.class),
    VIEWUSERS(ViewUsersAction.class),
    VIEWGOODS(ViewGoodsAction.class),
    VIEWTARIFFS(ViewTariffsAction.class),
    TARIFF(TariffAction.class);
    private Class<? extends Command> actionClass;

    private ActionEnum(Class<? extends Command> actionClass) {
        this.actionClass = actionClass;
    }

    public Command getAction() {
        Command abstractAction = null;
        try {
            abstractAction = actionClass.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        return abstractAction;
    }
}
