package androidTestMod.cards;

import androidTestMod.enums.CardColorEnum;
import androidTestMod.powers.DisappointedPower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PenNibPower;

public class DisappointedAfterBocchi extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DisappointedAfterBocchi");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/DisappointedAfterBocchi.png";
    public static final String ID = "DisappointedAfterBocchi";

    public DisappointedAfterBocchi(){
        super (ID, NAME, IMG_PATH, 1, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p , AbstractMonster m ){
        CardCrawlGame.sound.play("DisappointedAfterBocchi");
        this.addToBot(new ApplyPowerAction( p , p ,new PenNibPower( p , this.magicNumber)));
        this.addToBot(new ApplyPowerAction( p , p ,new DisappointedPower( p )));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(0);
        }
    }

    public AbstractCard makeCopy(){
        return new DisappointedAfterBocchi();
    }
}
