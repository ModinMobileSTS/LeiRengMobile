package androidTestMod.cards;

import androidTestMod.actions.DarknessCrawlAction;
import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DarknessCrawl extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DarknessCrawl");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/DarknessCrawl.png";
    private static final int COST = -1;
    private static final int UPGRADE_PLUS_MAGIC = 1;
    public static final String ID = "DarknessCrawl";

    public DarknessCrawl(){
        super (ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
        this.baseBlock = 6;
    }
    
    public void use(AbstractPlayer p, AbstractMonster m){
        CardCrawlGame.sound.play("DarknessCrawl");
        this.addToBot(new DarknessCrawlAction(p,this.block,this.upgraded,this.freeToPlayOnce,this.energyOnUse));
    }
    
    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }
    
    public AbstractCard makeCopy(){
        return new DarknessCrawl();
    }
}
