package ninja.cards;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import ninja.powers.NuclearDragonPower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class NuclearDragon extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("NuclearDragon");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/NuclearDragon.png";
    public static final String ID = "NuclearDragon";

    public NuclearDragon() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.exhaust = true;
        this.baseMagicNumber= 3;
        this.baseBlock = 4;
        this.magicNumber = baseMagicNumber;
    }


    public void use(AbstractPlayer p, AbstractMonster m){
                this.addToBot(new ApplyPowerAction(p,p,new NuclearDragonPower(p,this.magicNumber),this.magicNumber));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBlock(2);
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new NuclearDragon();
    }
}
