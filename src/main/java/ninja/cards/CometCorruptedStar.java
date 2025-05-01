package ninja.cards;

import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import ninja.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class CometCorruptedStar extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("CometCorruptedStar");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/CometCorruptedStar.png";
    public static final String ID = "CometCorruptedStar";

    public CometCorruptedStar(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.SELF);
        this.baseMagicNumber=1;
        this.magicNumber=this.baseMagicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
                AbstractPower lexkela = p.getPower("LexKela");

        if(lexkela != null && lexkela.amount <= 2){
            this.addToBot(new ApplyPowerAction(p,p,new LexKela(p,this.magicNumber),this.magicNumber));
        }
        else {
            if (lexkela == null) {
                this.addToBot(new ApplyPowerAction(p, p, new LexKela(p, this.magicNumber), this.magicNumber));
            }
            else {
                this.addToBot(new ApplyPowerAction(p, p, new LexKela(p, -1)));
                this.addToBot(new GainEnergyAction(1));
            }
        }

    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new CometCorruptedStar();
    }
}
