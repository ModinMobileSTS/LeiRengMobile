package ninja.cards;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import ninja.powers.SwallowPower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class FrzMudSwallow extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FrzMudSwallow");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/FrzMudSwallow.png";
    public static final String ID = "FrzMudSwallow";
    public static final int NINJUTSU = 1 ;

    public FrzMudSwallow(){
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m){
                this.addToTop(new DrawCardAction(1));
        this.addToTop(new ApplyPowerAction(p,p,new SwallowPower(p,1),1));

    }

    public void upgrade(){
        if(!upgraded){
            this.upgradeName();
            this.upgradeBaseCost(0);
        }
    }

    public AbstractCard makeCopy(){
        return new FrzMudSwallow();
    }
}
