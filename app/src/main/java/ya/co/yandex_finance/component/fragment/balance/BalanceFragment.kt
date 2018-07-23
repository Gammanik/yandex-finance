package ya.co.yandex_finance.component.fragment.balance

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import ya.co.yandex_finance.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import com.arellomobile.mvp.MvpAppCompatFragment
import kotlinx.android.synthetic.main.fragment_balance.*


class BalanceFragment : MvpAppCompatFragment(), BalanceView, AdapterView.OnItemSelectedListener {

    @InjectPresenter
    lateinit var balancePresenter: BalancePresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_balance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        balancePresenter.updateBalance()
        //todo: arrayOf myMoney && do it all in the presenter
//        val currencyNames = arrayOf("rub", "usd")
//        val adapter = ArrayAdapter<String>(activity!!.applicationContext, android.R.layout.simple_spinner_item, currencyNames)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        current_currency_spinner.adapter = adapter
//        current_currency_spinner.prompt = "Валюта"
        current_currency_spinner.onItemSelectedListener = this
        current_currency_spinner.setSelection(1)
    }


    override fun setBalance(balance: Double) {
        current_balance_amount.text = balance.toString()
    }


    override fun onNothingSelected(patent: AdapterView<*>) { }

    override fun onItemSelected(patent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        current_currency_spinner.setSelection(pos)
        chooseCurrency(if (pos == 0) "USD_CURR_NAME" else "RUB_CURR_NAME")
    }

    private fun chooseCurrency(currencyName: String) {
        balancePresenter.convertCurrencyTo(currencyName)
    }
}
