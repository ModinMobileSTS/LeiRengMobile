package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.actions.WaterSandAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.SandWall;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class WaterSandStorm extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("WaterSandStorm");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/WaterSandStorm.png";
    public static final String ID = "WaterSandStorm";

    public WaterSandStorm() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseMagicNumber = 10;
        this.magicNumber = baseMagicNumber;
        this.isMultiDamage = true;
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m){
        this.addToBot(new ApplyPowerAction(p,p,new SandWall(p,this.magicNumber),this.magicNumber));
        this.addToBot(new NinjutsuAction(p,new WaterSandAction(p),2,"WaterSandStorm"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(2);
        }
    }
    public AbstractCard makeCopy(){
        return new WaterSandStorm();
    }
}
