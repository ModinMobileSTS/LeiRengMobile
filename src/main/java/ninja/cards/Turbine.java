package ninja.cards;

import ninja.actions.ScienceAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.TurbinePower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class Turbine extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Turbine");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/Turbine.png";
    public static final String ID = "Turbine";

    public Turbine(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 5, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.tags.add(CardTags.SCIENCE);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
                this.addToBot(new ApplyPowerAction(p,p,new TurbinePower(p,1),1));
        this.addToBot(new ScienceAction(p));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(4);
        }
    }

    public AbstractCard makeCopy(){
        return new Turbine();
    }
}
