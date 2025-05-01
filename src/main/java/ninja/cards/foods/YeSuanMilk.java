package ninja.cards.foods;

import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class YeSuanMilk extends CustomCard {

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("YeSuanMilk");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/YeSuanMilk.png";
    public static final String ID = "YeSuanMilk";

    public YeSuanMilk() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, CardType.SKILL, CardColor.COLORLESS, CardRarity.SPECIAL, CardTarget.SELF);
        this.baseMagicNumber = 3;
        this.magicNumber = baseMagicNumber;
        this.tags.add(CardTags.FOOD);
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m){
                this.addToBot(new ApplyPowerAction(p,p,new LexKela(p,this.magicNumber)));
    }
    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new YeSuanMilk();
    }
}
